package org.al.ecommerce.services.userService;



import com.google.gson.Gson;
import org.al.ecommerce.database.entity.User;
import org.al.ecommerce.utilities.EcommerceConnection;
import org.al.ecommerce.utilities.JsonResponse;
import org.al.ecommerce.utilities.ServicePaths;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/")

public class UserService {



    @POST
    @Path(ServicePaths.ECOMMERCE_USER_LOGIN_CONTROL)
    @Produces(MediaType.APPLICATION_JSON)
    public String  controlUserAccess(@FormParam("REQUEST_DATA") String requestData)
    {
        JsonResponse jsonResponse = new JsonResponse();
        Gson gson = new Gson();

        User userCredential = gson.fromJson(requestData, User.class);
        EntityManagerFactory entityManagerFactory = EcommerceConnection.createFactoryManager();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query userQuery = entityManager.createQuery("select  user from User user where email= :email and password= :password");
        userQuery.setParameter("email", userCredential.getEmail());
        userQuery.setParameter("password", userCredential.getPassword());
        entityManager.close();
        entityManagerFactory.close();

        List<User> user = userQuery.getResultList();

        if(user.size()>0)
        {
            jsonResponse.setResponseCode("1");
            jsonResponse.setResponseData(user.toString());
            return gson.toJson(jsonResponse);
        }else{

            jsonResponse.setResponseCode("0");

            jsonResponse.setResponseMessage("Perdoruesi nuk u gjend");

            return gson.toJson(jsonResponse);
        }

    }


    @POST
    @Path(ServicePaths.ECCOMERCE_USER_SIGNUP)
    @Produces(MediaType.APPLICATION_JSON)
    public static String registerUser(@FormParam("REQUEST_DATA") String requestData)
    {
        JsonResponse jsonResponse = new JsonResponse();
        Gson gson = new Gson();
        User userCredential = gson.fromJson(requestData, User.class);
        EntityManagerFactory entityManagerFactory = EcommerceConnection.createFactoryManager();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query userQuery = entityManager.createQuery("select  user from User user where email= :email and password= :password");
        userQuery.setParameter("email", userCredential.getEmail());
        userQuery.setParameter("password", userCredential.getPassword());

        List<User> user = userQuery.getResultList();

        if(user.size()>0)
        {
            jsonResponse.setReponseMessageAndCode("Na vjen keq! Perdoruesi ekziston", "0");
            return gson.toJson(jsonResponse);
        }else{

            entityManager.getTransaction().begin();
            entityManager.persist(userCredential);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            jsonResponse.setReponseMessageAndCode("Success! Perdoruesi u regjistrua me sukses", "1");
            jsonResponse.setResponseData(userCredential.toString());
            return gson.toJson(jsonResponse);
        }


    }

}
