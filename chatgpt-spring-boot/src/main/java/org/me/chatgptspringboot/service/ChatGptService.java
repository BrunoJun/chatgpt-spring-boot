package org.me.chatgptspringboot.service;

import org.me.chatgptspringboot.vo.request.ChatGptRequest;
import org.me.chatgptspringboot.vo.response.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class ChatGptService {

    private Logger logger = Logger.getLogger(ChatGptService.class.getName());

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;

    @Autowired
    private RestTemplate template;

    public String chat(String prompt){

        logger.info("Starting Prompt!");

        ChatGptRequest request = new ChatGptRequest(model, prompt);

        logger.info("Processing Prompt!");

        ChatGptResponse response = template.postForObject(url, request, ChatGptResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }
}
