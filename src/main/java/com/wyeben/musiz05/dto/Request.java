package com.wyeben.musiz05.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Request {
    private String songTitle;
    private String artistName;
    private String lastUpdate;
}
