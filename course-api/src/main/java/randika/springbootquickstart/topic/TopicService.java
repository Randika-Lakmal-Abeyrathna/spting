package randika.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
		new Topic("1", "Topic 1", "topic 1"),
		new Topic("2", "Topic 2", "topic 2"),
		new Topic("3", "Topic 3", "topic 3")
		));

public List<Topic> getAllTopics(){
	return topics;
}

public Topic getTopic(String id) {
	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	
} 

public void addTopic(Topic topic) {
	topics.add(topic);
}

public void updateTopic(Topic topic, String id) {
	for (int i = 0; i < topics.size(); i++) {
		Topic t = topics.get(i);
		if(t.getId().equals(id)) {
			topics.set(i, topic);
			return;
		} 
	}
	
}

public void deleteTopic(String id) {
	topics.removeIf(t ->t.getId().equals(id));
}


}
