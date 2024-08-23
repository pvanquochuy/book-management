package com.example.notification_service.service;

import com.example.notification_service.dto.request.EmailRequest;
import com.example.notification_service.dto.request.SendEmailRequest;
import com.example.notification_service.dto.request.Sender;
import com.example.notification_service.dto.response.EmailResponse;
import com.example.notification_service.exception.AppException;
import com.example.notification_service.exception.ErrorCode;
import com.example.notification_service.repository.httpclient.EmailClient;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;
    String apiKey = "xkeysib-dc0096c633b284 9864307ce491bdf21eeebe326a416a18554133bae3a74e6544-cfpUWZNVQSjroPcp";

    public EmailResponse sendEmail(SendEmailRequest request){
        EmailRequest emailRequest = EmailRequest.builder()
                        .sender(Sender.builder()
                                .name("Quoc Huy")
                                .email("pvanquochuy@gmail.com")
                                .build())
                        .to(List.of(request.getTo()))
                        .subject(request.getSubject())
                        .htmlContent(request.getHtmlContent())
                        .build();
        try {
             return emailClient.sendEmail(apiKey, emailRequest);
        }catch (FeignException e){
            throw new AppException(ErrorCode.CANNOT_SEND_EMAIL);

        }
    }

}
