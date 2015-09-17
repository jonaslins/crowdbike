package com.software.project.service.rest;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.software.project.service.rest.resource.LoginResource;
import com.software.project.service.rest.resource.SignUpResource;



public class ServerApp extends Application{
	Router router;
    public ServerApp() {
        super();
    }
    

  public ServerApp(Context context) {
        super(context);
    }

    @Override
    public synchronized Restlet createInboundRoot() {
        Router router = new Router(getContext()); 
        router.attach("/signup", SignUpResource.class);
        router.attach("/login", LoginResource.class); 
        return router;
    }

	public Router getrouter() {
		return router;
	}

	public void setrouter(Router router) {
		this.router = router;
	}


	
	
}
