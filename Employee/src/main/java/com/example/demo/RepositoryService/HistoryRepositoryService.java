
package com.example.demo.RepositoryService;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Definitions.History;

public interface HistoryRepositoryService extends JpaRepository<History, Long> {

}
