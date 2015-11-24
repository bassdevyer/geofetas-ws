package com.geofertas.ws;

import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by whoami on 11/22/15.
 * Defines the web service interface
 */
@WebService
interface GeofertasService {

    // Customizes the mapping of the return value to a WSDL part and XML element.s
    @WebResult
    String sayHello(String name);

}
