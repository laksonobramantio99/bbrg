package brg.bbrg.setting;

import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

public class CustomUriBuilderFactory extends DefaultUriBuilderFactory {

    public CustomUriBuilderFactory(String baseUriTemplate) {
        super(UriComponentsBuilder.fromHttpUrl(baseUriTemplate));
        super.setEncodingMode(EncodingMode.NONE);
    }
}
