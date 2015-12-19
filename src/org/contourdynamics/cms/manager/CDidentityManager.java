package org.contourdynamics.cms.manager;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.picketlink.Identity;
import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.credential.Password;
import org.contourdynamics.cms.idm.model.User;
import org.picketlink.idm.query.IdentityQuery;
import org.picketlink.idm.query.IdentityQueryBuilder;
import org.picketlink.idm.credential.UsernamePasswordCredentials;
import org.contourdynamics.cms.idm.model.Realm;
import org.contourdynamics.cms.navigations.Windows;
import org.contourdynamics.cms.producers.CDMessages;

@Named("IdentityManager")
@RequestScoped
@PicketLink
public class CDidentityManager extends BaseAuthenticator{

	private String realm="";
	
	@Inject
	private PartitionManager partitionManager;
	
//	@Inject
 //   private ViewNavigationHandler viewNavigationHandler;
	
	@Inject
    private CDMessages messages;
	
	@Inject 
	private Identity identity;
	@Inject 
	DefaultLoginCredentials credentials;

	public String getrealm()
	{
		return realm;
	}
	public void setrealm(String thisrealm)
	{
		realm = thisrealm;
	}
	@Override
	@Transactional(qualifier = PicketLink.class)
	public void authenticate() 
	{
		if(!identity.isLoggedIn())
		{
			FacesContext context = FacesContext.getCurrentInstance();
			if (realm.isEmpty())
			{
				context.addMessage("Realm",new FacesMessage(messages.DomainRequired()));
			}
			if (credentials.getUserId().isEmpty())
			{
				context.addMessage("username",new FacesMessage(messages.UsernameRequired()));
			}
			if (credentials.getPassword().isEmpty())
			{
				context.addMessage("password",new FacesMessage(messages.PasswordRequired()));
			}
					
			Realm storedRealm = partitionManager.getPartition(Realm.class, realm);
			if(storedRealm == null)
			{
				context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!", messages.LoginStatusFailure()));
				return;
			}
			IdentityManager identityManager = partitionManager.createIdentityManager(storedRealm);
			
			Password password = new Password(credentials.getPassword());
			UsernamePasswordCredentials m_credentials = new UsernamePasswordCredentials(credentials.getUserId(), password);
			identityManager.validateCredentials(m_credentials);
	        org.picketlink.idm.credential.Credentials.Status status = m_credentials.getStatus();
	        if (status == org.picketlink.idm.credential.Credentials.Status.INVALID)
	        {
				context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!", messages.LoginStatusFailure()));
				return;
	        }
	        IdentityQueryBuilder queryBuilder = identityManager.getQueryBuilder();
	        IdentityQuery<User> query = queryBuilder.createIdentityQuery(User.class);
	
	        // let's check if the user is stored by querying by name
	        query.where(queryBuilder.equal(User.USER_NAME, credentials.getUserId()));
	
	        List<User> users = query.getResultList();
	
	        setStatus(AuthenticationStatus.SUCCESS);
	        setAccount(users.get(0));
	//		UserIdentity user = new UserIdentity();
	//		user.setUsername(Username);
	//		user.setPassword(Password);
	//		model.SaveUser(user);
	//		System.out.print("this is test");
		}
      //  this.viewNavigationHandler.navigateTo(Windows.contourdynamics.class);
	}
}
