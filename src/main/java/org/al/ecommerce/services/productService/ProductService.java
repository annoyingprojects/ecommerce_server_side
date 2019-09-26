package org.al.ecommerce.services.productService;

import com.google.gson.Gson;
import org.al.ecommerce.database.entity.Details;
import org.al.ecommerce.utilities.EcommerceConnection;
import org.al.ecommerce.utilities.JsonResponse;
import org.al.ecommerce.utilities.ServicePaths;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/")
public class ProductService {

    @POST
    @Path(ServicePaths.ECOMMERCE_PRODUCT_DETAILS)
    public String getProductDetails(@FormParam("PRODUCT_ID") int productId)
    {
        JsonResponse jsonResponse = new JsonResponse();
        Gson gson = new Gson();
        try {
            EntityManagerFactory entityManagerFactory = EcommerceConnection.createFactoryManager();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Details productDetails = entityManager.find(Details.class, productId);
            return gson.toJson(productDetails.toString());

        }catch(Exception e)
        {
            e.printStackTrace();
            jsonResponse.setReponseMessageAndCode("Error ne marrjen e te dhneave te produktit", "0");
                  return gson.toJson(jsonResponse);
        }
    }
}
