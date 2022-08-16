package toggles;

import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.NoOpUserProvider;
import org.togglz.core.user.UserProvider;

public class MyTogglzConfig  implements TogglzConfig {
    
    @Override
    public Class<? extends Feature> getFeatureClass() {
        return MyFeatures.class;
    }
    
    @Override
    public StateRepository getStateRepository() { // https://www.togglz.org/documentation/repositories.html
        InMemoryStateRepository inMemoryStateRepository = new InMemoryStateRepository();
        inMemoryStateRepository.setFeatureState(new FeatureState(MyFeatures.LOGGING_TRACE, false));
        return inMemoryStateRepository;
    }
    
    @Override
    public UserProvider getUserProvider() {
        return new NoOpUserProvider();
    }
}
