package io.davidarchanjo;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Setter
@Component
public class Triangle implements InitializingBean, DisposableBean {
    
    @Autowired
    @Qualifier("pointA")
    private Point pointA;

    @Autowired
    @Qualifier("pointB")
    private Point pointB;

    @Autowired
    @Qualifier("pointC")
    private Point pointC;

    public void draw() {
        log.info("PointA is ({}, {})", pointA.getX(), pointA.getY());
        log.info("PointB is ({}, {})", pointB.getX(), pointB.getY());
        log.info("PointC is ({}, {})", pointC.getX(), pointC.getY());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Bean initialization method - triangle");
    }

    @Override
    public void destroy() throws Exception {
        log.info("Bean destruction method - triangle");
    }

    @PostConstruct
    public void customInit() {
        log.info("@PostConstruct method - triangle");
    }

    @PreDestroy
    public void customDestroy() {
        log.info("@PreDestroy method - triangle");
    }
}