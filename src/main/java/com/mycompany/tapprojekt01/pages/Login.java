package com.mycompany.tapprojekt01.pages;

import com.mycompany.tapprojekt.dao.UserDao;
import com.mycompany.tapprojekt01.data.Role;
import com.mycompany.tapprojekt01.entities.User;
import com.mycompany.tapprojekt01.services.FacebookService;
import com.mycompany.tapprojekt01.services.FacebookServiceInformation;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import java.io.IOException;
import net.smartam.leeloo.common.exception.OAuthProblemException;
import net.smartam.leeloo.common.exception.OAuthSystemException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;
import org.tynamo.security.services.SecurityService;

public class Login {

    @Inject
    private UserDao userDao;
    @Property
    private User userLogin;
    @SessionState
    private User loggedInUser;
    @Component
    private BeanEditForm form;
    @Inject
    private SecurityService securityService;
    @Inject
    private FacebookService facebookService;
    @SessionState
    @Property
    private FacebookServiceInformation facebookServiceInformation;
    @SessionState
    @Property
    private FacebookServiceInformation information;
    @Property
    private com.restfb.types.User userfb;
    @Property
    @ActivationRequestParameter
    private String code;

    Object onActivate() {
        if (loggedInUser.getEmail() != null) {
            return Index.class;
        }
        return null;
    }

    public String getMD5Hash(String yourString) {
        try {
            java.security.MessageDigest md
                    = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(yourString.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,
                        3));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    Object onSuccess() {
        String password = getMD5Hash(userLogin.getSifra());
        System.out.println(password);
        User u = userDao.checkUser(userLogin.getEmail(), password);
        if (u != null) {
            loggedInUser = u;
            System.out.println("Logovan");
            Subject currentUser = securityService.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(u.getEmail(),
                    userLogin.getSifra());
            try {
                currentUser.login(token);
            } catch (Exception e) {
                form.recordError("Uneli ste pogrešne parametre");
            }
            return Index.class;
        } else {
            form.recordError("Uneli ste pogrešne parametre");
            System.out.println("losi parametri");
            return null;
        }
    }

    public String getFacebookAuthentificationLink() throws OAuthSystemException {
        return facebookService.getFacebookAuthentificationLink();
    }

    @CommitAfter
    public boolean isLoggedInFb() {
        if (facebookServiceInformation.getAccessToken() != null) {
            User fbuser = new User(userfb.getEmail(), " ", Role.Korisnik,
                    userfb.getId());
            User exist = null;
            System.out.println("proverava");
            exist = userDao.checkIfFbExists(userfb.getId());
            if (exist == null) {
                userDao.registerUser(fbuser);
                loggedInUser = fbuser;
                System.out.println("registruje");
            } else {
                loggedInUser = exist;
                System.out.println("postoji");
            }
        }
        return facebookServiceInformation.getAccessToken() != null;
    }

    @SetupRender
    public void setup() throws IOException, OAuthSystemException,
            OAuthProblemException {
        if (code != null) {
            facebookService.getUserAccessToken(code,
                    information.getAccessToken());
        }
        code = null;
        FacebookClient facebookClient = new DefaultFacebookClient(information.getAccessToken());
        if (information.isLoggedIn()) {
            userfb = facebookClient.fetchObject("me", com.restfb.types.User.class);
        }
    }
}
