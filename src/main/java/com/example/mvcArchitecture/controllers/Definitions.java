package com.example.mvcArchitecture.controllers;

public class Definitions {
//    Controller-level Annotations

//1. @RestController

    //Combines @Controller + @ResponseBody.

    //It tells Spring this class is a web controller where every method returns data (like JSON), not a view (HTML template).

    //Spring automatically converts Java objects to JSON using Jackson.

//    2. @RequestMapping

    //    Used at the class or method level to define a base URL for all endpoints inside.
    //    You can set:
    //    path → the URL
    //    method → HTTP method (GET, POST, etc.)
    //    produces or consumes → MIME type control

//    3. @GetMapping

    //Handles HTTP GET (used to read data).
    //Shortcut for @RequestMapping(method = RequestMethod.GET).

//    🔄 Parameter-binding Annotations

        //These tell Spring where to get your method parameters from in the HTTP request.

        //1. @PathVariable

        //Binds a URL path segment to a parameter.

//    2 . @RequestParam

        //Binds a query parameter from the URL.
        //Optional or required based on your needs.

//    3. @RequestBody

        //Maps the JSON body of the request to a Java object automatically.
        //Common with POST or PUT.
}
