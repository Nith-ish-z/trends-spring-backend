package com.ecom.trends.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class EmailService {

    @Value("${brevo.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendOtpAsync(String toEmail, String otp) {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("api-key", apiKey);

            Map<String, Object> payload = Map.of(
                    "sender", Map.of(
                            "email", "nithishattur63@gmail.com",
                            "name", "Trends"
                    ),
                    "to", new Object[]{
                            Map.of("email", toEmail)
                    },
                    "subject", "Verify your email address – OTP for Trends",
                    "htmlContent",
                    """
                    <div style="font-family: Arial, sans-serif; line-height: 1.6; color: #333;">
                        <h2 style="color:#111;">Verify your email address</h2>
                        <p>Hello,</p>
                        <p>Thank you for signing up with <strong>Trends</strong>.</p>
            
                        <p>Please use the following One-Time Password (OTP) to complete your verification:</p>
            
                        <div style="font-size: 24px; font-weight: bold; letter-spacing: 4px; margin: 16px 0;">
                            """ + otp + """
                        </div>

                        <p>This OTP is valid for <strong>5 minutes</strong>.</p>
            
                        <p>If you did not request this verification, please ignore this email.</p>
            
                        <p style="margin-top: 24px;">
                            Regards,<br>
                            <strong>Trends Team</strong>
                        </p>
                    </div>
                    """
            );

            HttpEntity<Map<String, Object>> request =
                    new HttpEntity<>(payload, headers);

            restTemplate.postForEntity(
                    "https://api.brevo.com/v3/smtp/email",
                    request,
                    String.class
            );

        } catch (Exception ex) {
            // NEVER crash signup flow
            System.err.println("Brevo mail failed: " + ex.getMessage());
        }
    }
}
