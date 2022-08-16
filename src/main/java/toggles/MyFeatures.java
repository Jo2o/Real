package toggles;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum MyFeatures implements Feature {
    
    //@EnabledByDefault
    @Label("LoggingTraceLabel")
    LOGGING_TRACE;
    
}
