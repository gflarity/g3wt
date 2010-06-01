
package g3wt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint {
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

	DataServiceAsync myService = (DataServiceAsync) GWT.create(DataService.class);

	ServiceDefTarget endpoint = (ServiceDefTarget) myService;

	// Note the URL where the RPC service is located!
	String moduleRelativeURL = GWT.getModuleBaseURL() + "rpc";
	endpoint.setServiceEntryPoint(moduleRelativeURL);

	// Call a method on the service!
	myService.helloWorld( new AsyncCallback() {
		public void onSuccess(Object result) {
		    // It's always safe to downcast to the known return type.
		    String resultString = ( String ) result;
		    Window.alert( resultString );
		}
		
		public void onFailure(Throwable caught) {
		}
		
	    }
	    );	
    }
}
