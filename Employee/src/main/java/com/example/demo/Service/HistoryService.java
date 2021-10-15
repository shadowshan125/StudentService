
package com.example.demo.Service;

import org.springframework.stereotype.Component;

import com.example.demo.Definitions.History;

@Component
public interface HistoryService {

	History Update(History params, long id);

}
