package toggles;

import lombok.extern.slf4j.Slf4j;
import org.togglz.core.context.StaticFeatureManagerProvider;
import org.togglz.core.manager.FeatureManagerBuilder;

@Slf4j
public class Main {
    
    public static void main(String[] args) {
        
        togglzSetup();
        
        log.info("Printing always without togglz.");
        
        if (MyFeatures.LOGGING_TRACE.isActive()) {
            log.info("Printing only if feature is toggled ON.");
        }
        
    }
    
    private static void togglzSetup() {
        StaticFeatureManagerProvider.setFeatureManager(
            new FeatureManagerBuilder()
                .togglzConfig(new MyTogglzConfig())
                .build());
    }
}
