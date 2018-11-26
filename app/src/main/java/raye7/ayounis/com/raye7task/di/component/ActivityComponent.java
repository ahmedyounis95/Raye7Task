package raye7.ayounis.com.raye7task.di.component;

import dagger.Component;
import raye7.ayounis.com.raye7task.di.PerActivity;
import raye7.ayounis.com.raye7task.di.module.ActivityModule;

/**
 * Created by Ahmed Younis on 11/26/2018.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent  {


/*
    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);
*/

}
