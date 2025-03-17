package com.site.diary.SMS;

import net.nurigo.sdk.message.model.Message; // ✅ 변경된 패키지 경로
import net.nurigo.sdk.message.service.DefaultMessageService; // ✅ SMS 서비스 추가
import net.nurigo.sdk.NurigoApp;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


/**
 * 인증 시 비용 발생으로 중단
 * 
 * @since 2025-03-17
 */

@Service
public class SmsService {
    private static final String API_KEY = "";
    private static final String API_SECRET = "";
    private static final String FROM_NUMBER = "";

    private final DefaultMessageService messageService;

    public SmsService() {
        this.messageService = NurigoApp.INSTANCE.initialize(API_KEY, API_SECRET, "https://api.coolsms.co.kr");
    }

    public boolean sendSms(String phoneNumber, String messageText) {
        try {
            Message message = new Message();
            message.setFrom(FROM_NUMBER);
            message.setTo(phoneNumber);
            message.setText(messageText);

            List<Message> messageList = new ArrayList<>();
            messageList.add(message);

            // 메시지 전송
            this.messageService.send(messageList);

            return true;
        } catch (Exception e) {
            System.out.println("SMS 전송 실패: " + e.getMessage());
            return false;
        }
    }
}
