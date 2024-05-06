package com.mystore.testcases;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.mystore.testcases.TC_IndexPageTest.ProductNameOfsecondHighestPrice;
import static com.mystore.testcases.TC_IndexPageTest.uiProductCount;

public class FlipkartAPITesting {
    FlipkartAPI flipkartAPI = new FlipkartAPI();

    @Test
    public void testGetProductsAndValidate() {
        Response response = flipkartAPI.searchProducts("Samsung Galaxy S24", true, 256);

        // Assuming API gives total product count somewhere in the response
        JsonPath jsonPath = response.jsonPath();
        int apiProductCount = jsonPath.getInt("totalProducts");
        int extractedProductNamesCount =  jsonPath.getList("products.productName").size();

        List<Object> productNames = jsonPath.getList("products.productName");
        System.out.println("Prod Names are: ");
        for(Object productName: productNames){
            System.out.println(productName.toString());
        }
        FlipkartDatabase db = new FlipkartDatabase();
        //Validate the product name returned by the query is matching with the Product Name stored in the variable (Task No 7)
        Assert.assertEquals(ProductNameOfsecondHighestPrice, db.getSecondHighestPricedProduct());
        // Replace with the part where you compare UI count

        Assert.assertEquals(apiProductCount, uiProductCount);
        Assert.assertEquals(extractedProductNamesCount, uiProductCount);
    }
}
