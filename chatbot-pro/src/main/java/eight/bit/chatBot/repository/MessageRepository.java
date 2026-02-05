package eight.bit.chatBot.repository;

import eight.bit.chatBot.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<ChatMessage, Long> {
    // Fetches 1-to-1 history between two people in the same department
    List<ChatMessage> findBySenderIdAndRecipientIdOrSenderIdAndRecipientIdOrderByTimestampAsc(
            String s1, String r1, String s2, String r2
    );
}
