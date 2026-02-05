package eight.bit.chatBot.service;

import eight.bit.chatBot.entity.ChatMessage;
import eight.bit.chatBot.entity.User;
import eight.bit.chatBot.repository.MessageRepository;
import eight.bit.chatBot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired private UserRepository userRepository;

    public ChatMessage saveMessage(ChatMessage message) {
        User sender = userRepository.findByUsername(message.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        User recipient = userRepository.findByUsername(message.getRecipientId())
                .orElseThrow(() -> new RuntimeException("Recipient not found"));

        // STRICT CHECK: Ensure they are in the same department
        if (!sender.getDepartment().equals(recipient.getDepartment())) {
            throw new RuntimeException("Cross-department chat is not allowed!");
        }

        message.setTimestamp(LocalDateTime.now());
        message.setDepartment(sender.getDepartment());
        return messageRepository.save(message);
    }

    public List<ChatMessage> getChatHistory(String senderId, String recipientId) {
        return messageRepository.findBySenderIdAndRecipientIdOrSenderIdAndRecipientIdOrderByTimestampAsc(
                senderId, recipientId, recipientId, senderId
        );
    }
}
