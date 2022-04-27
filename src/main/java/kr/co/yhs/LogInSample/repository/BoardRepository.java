package kr.co.yhs.LogInSample.repository;

import kr.co.yhs.LogInSample.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
