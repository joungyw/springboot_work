package org.example.conponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("AABBService")
public class AABBService {

    @Autowired(required = false)
    AA aa;

    @Autowired(required = false)
    BB bb;
}
