package backend.WebSocket;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@ServerEndpoint("/websocket/duwe/{username}")
@Component
/**
 * 
 * @author Danny Yip, Cobi Mom
 * class of a DuweFan club
 */
public class DuweFanClubServer {
	
	// Store all socket session and their corresponding username.
    /**
     * private instance variable of a map of sessionUsernameMap
     */
	private static Map<Session, String> sessionUsernameMap = new HashMap<>();
    /**
     * private instance variable of a map of usernameSessionMap
     */
	private static Map<String, Session> usernameSessionMap = new HashMap<>();
	/**
     * private instance of a logger
	 */
    private final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    
    @OnOpen
    /**
     * method of on open 
     * @param session a session to connect 
     * @param username user name
     * @throws IOException 
     * exception Input or output
     */
    public void onOpen(
    	      Session session, 
    	      @PathParam("username") String username) throws IOException 
    {
        logger.info("Entered into Open");
        
        sessionUsernameMap.put(session, username);
        usernameSessionMap.put(username, session);
        
        String message = username + " has Joined The Duwe Fan Club Chat";
        	broadcast(message);
		
    }
 
    @OnMessage
    /**
     * on Message method
     * 
     * @param session a session to connect 
     * @param message message to input
     * @throws IOException
     * exception Input or output
     */
    public void onMessage(Session session, String message) throws IOException 
    {
        // Handle new messages
    	logger.info("Entered into Message: Got Message:"+message);
    	String username = sessionUsernameMap.get(session);
    	
    	if (message.startsWith("@")) // Direct message to a user using the format "@username <message>"
    	{
    		String destUsername = message.split(" ")[0].substring(1); // don't do this in your code!
    		sendMessageToPArticularUser(destUsername, "[DM] " + username + ": " + message);
    		sendMessageToPArticularUser(username, "[DM] " + username + ": " + message);
    	}
    	else // Message to whole chat
    	{
	    	broadcast(username + ": " + message);
    	}
    }
 
    @OnClose
    /**
     * close the session 
     * @param session a session to connect 
     * @throws IOException 
     * exception Input or output
     */
    public void onClose(Session session) throws IOException
    {
    	logger.info("Entered into Close");
    	
    	String username = sessionUsernameMap.get(session);
    	sessionUsernameMap.remove(session);
    	usernameSessionMap.remove(username);
        
    	String message= username + " disconnected";
        broadcast(message);
    }
 
    @OnError
    /**
     * method on error
     * @param session a session to connect 
     * @param throwable throwable variable
     */
    public void onError(Session session, Throwable throwable) 
    {
        // Do error handling here
    	logger.info("Entered into Error");
    }
    
    /**
     * send message to particular user
     * 
     * @param username users name
     * @param message users message
     */
	private void sendMessageToPArticularUser(String username, String message) 
    {	
    	try {
    		usernameSessionMap.get(username).getBasicRemote().sendText(message);
        } catch (IOException e) {
        	logger.info("Exception: " + e.getMessage().toString());
            e.printStackTrace();
        }
    }
    
	/**
	 * braodcast to all server
	 * @param message users or server message
	 * @throws IOException 
	 * exception Input or output
	 */
    private static void broadcast(String message) 
    	      throws IOException 
    {	  
    	sessionUsernameMap.forEach((session, username) -> {
    		synchronized (session) {
	            try {
	           		session.getBasicRemote().sendText(message);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
}
