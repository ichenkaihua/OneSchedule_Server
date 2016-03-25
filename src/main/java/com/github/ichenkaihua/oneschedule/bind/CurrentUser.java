

package com.github.ichenkaihua.oneschedule.bind;

import com.github.ichenkaihua.oneschedule.Contants;

import java.lang.annotation.*;


@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    String value() default Contants.CURRENT_USER;

}
