package ru.oldjew.telegrambotexample.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import ru.oldjew.telegrambotexample.dto.*;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import java.nio.charset.StandardCharsets;

@Configuration
public class AppConfig {
    @Bean
    public CentralRussianBankService cbrService() throws SOAPException {
        CentralRussianBankService centralRussianBankService = new CentralRussianBankService();
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SaajSoapMessageFactory soapMessageFactory = new SaajSoapMessageFactory(messageFactory);
        centralRussianBankService.setMessageFactory(soapMessageFactory);

        jaxb2Marshaller.setClassesToBeBound(
                GetCursOnDateXml.class,
                GetCursOnDateXmlResponse.class,
                GetCursOnDateXmlResult.class,
                ValuteCursOnDate.class
        );

        centralRussianBankService.setMarshaller(jaxb2Marshaller);
        centralRussianBankService.setUnmarshaller(jaxb2Marshaller);

        return centralRussianBankService;
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter(){
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding(StandardCharsets.UTF_8.name());
        filter.setForceEncoding(true);
        return filter;
    }
}
