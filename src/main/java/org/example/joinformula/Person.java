package org.example.joinformula;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JoinFormula;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "person")
    private List<History> historyList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinFormula("(SELECT history.id FROM history WHERE history.person_id = id ORDER BY history.date DESC LIMIT 1)")
    private History activeHistory;
}
