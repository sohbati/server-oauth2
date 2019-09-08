package com.rsp.myserver.aspect;

import com.rsp.myserver.configuration.properties.SecurityProperties;
import com.rsp.myserver.dto.request.Request;
import com.rsp.myserver.exception.IpAddressInvalidException;
import com.rsp.myserver.exception.MacInvalidException;
import com.rsp.myserver.persistence.local.service.IPListService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class SecurityAspectImpl {

    @Autowired
    IPListService ipListService;

    @Autowired
    private SecurityProperties securityProperties;

    @Around("@annotation(com.rsp.myserver.aspect.SecurityAspect) ")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        if (!validateIPAddress()) {
            throw new IpAddressInvalidException();
        }
        Object[] args = joinPoint.getArgs();
        Request request = (Request) args[0];
        if (!validateMAC(request)) {
            throw new MacInvalidException();
        }

        return joinPoint.proceed();
    }

    private boolean validateIPAddress() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        return ipListService.isIpExistsInLocalDB(ip);
    }

    private boolean validateMAC(Request request) {

        String requestMac = request.getMac();
        String testKey = securityProperties.getMac().getKey();
        String testDelimiter = securityProperties.getMac().getDelimiter();
        String generatedMac = "";// generate mac

        //return requestMac.equals(generatedMac);
        return true;// test only
    }
}
