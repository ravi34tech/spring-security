# spring-security
spring boot security demo project, basic jpa authentication 
just providing the login security

refered from https://javatechonline.com/how-to-implement-security-in-spring-boot-project

**How does security work internally in a Spring Boot Application ?**

Fundamentaly, spring security works on a concept called JAAS(Java Authentication and Authorization Services). In brief, it works on Filter (javax.servlet.Filter) concept. We all know that we can use the Filters if we want to apply some pre-processing logic before a servlet request. The same concept has been applied to implement security features in Spring boot projects as well. _DelegatingFilterProxy_ is a predefined class under package org.springframework.web.filter provided by Spring Security module which acts as a filter here. As shown in the diagram below when a user sends a request to the application it passes through a security filter before going to DispatcherServlet. If user validates the security of this filter, then only the request will go to DispatcherServlet to serve the user’s purpose.
