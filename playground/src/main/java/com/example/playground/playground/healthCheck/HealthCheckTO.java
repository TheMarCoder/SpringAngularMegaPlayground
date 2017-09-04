package com.example.playground.playground.healthCheck;

import java.io.Serializable;

/**
 * Created by BurggrafM on 13.07.2017.
 */
public class HealthCheckTO implements Serializable {
        private String content = "Backend healthCheck ... OK";

        public void setContent(String content) {
          this.content = content;
        }
        public String getContent() {
          return content;
        }
    }
