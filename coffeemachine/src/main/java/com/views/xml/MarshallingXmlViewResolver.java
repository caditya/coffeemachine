package com.views.xml;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

/*
 * View resolver for returning XML in a view-based system. Always returns a
 * {@link MarshallingView}.
 */
public class MarshallingXmlViewResolver implements ViewResolver {

        private Marshaller marshaller;

        @Autowired
        public MarshallingXmlViewResolver(Marshaller marshaller) {
                this.marshaller = marshaller;
        }
        
        public MarshallingXmlViewResolver(){}

        /**
         * Get the view to use.
         * 
         * @return Always returns an instance of {@link MappingJacksonJsonView}.
         */
        @Override
        public View resolveViewName(String viewName, Locale locale)
                        throws Exception {
                MarshallingView view = new MarshallingView();
                view.setMarshaller(marshaller);
                return view;
        }

}