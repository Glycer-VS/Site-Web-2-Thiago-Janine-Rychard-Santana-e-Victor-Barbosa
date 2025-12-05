package br.ufrrj.extensao.repository;

import br.ufrrj.extensao.model.AcaoExtensao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AcaoRepository {
    private static List<AcaoExtensao> acoes = new ArrayList<>();

    static {
        acoes.add(new AcaoExtensao(1,
                "Curso de Arduíno",
                "Curso de Arduíno para iniciantes promovido pelo Departamento de Computação.",
                "Prof. Luiz Maltar",
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 6, 30),
                "PAP - SALA 3",
                "Alunos de SI",
                false,
                "http://ufrrj/curso-arduino",
                "ATIVA"));

        acoes.add(new AcaoExtensao(2,
                "Palestra sobre Projeto de Software",
                "Palestra para alunos do ensino médio.",
                "Prof. Eduardo Kinder",
                LocalDate.of(2024, 10, 5),
                LocalDate.of(2024, 11, 20),
                "Auditório do PAT",
                "Estudantes",
                true,
                "http://ufrrj/palestra",
                "ENCERRADA"));

        acoes.add(new AcaoExtensao(3,
                "Aulão de Desenvolvimento Web",
                "Aula sobre os sistemas Web da UFRRJ",
                "Prof. Tiago França",
                LocalDate.of(2025, 8, 10),
                LocalDate.of(2026, 2, 28),
                "PAP - LAB 3",
                "Todas as turmas de SI",
                false,
                "http://ufrrj/aulão",
                "ATIVA"));

        acoes.add(new AcaoExtensao(4,
                "Seminário de Sistemas Operacionais",
                "Palestras e painéis com o especialista em SO.",
                "Prof. Márcio Miranda",
                LocalDate.of(2025, 11, 5),
                LocalDate.of(2025, 11, 7),
                "Auditório P1",
                "Todas as turmas da UFRRJ",
                false,
                "http://ufrrj/seminário-so",
                "ATIVA"));

        acoes.add(new AcaoExtensao(5,
                "Curso de JAVA",
                "Curso introdutório de Java Orientado a Objetos.",
                "Prof. Gizelle Kupac",
                LocalDate.of(2024, 5, 15),
                LocalDate.of(2024, 7, 15),
                "Laboratório de Informática",
                "Todas as turmas de SI",
                true,
                "http://ufrrj/curso-java",
                "ENCERRADA"));
    }

    public static List<AcaoExtensao> getAll() {
        return Collections.unmodifiableList(acoes);
    }

    public static AcaoExtensao getById(int id) {
        return acoes.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static List<AcaoExtensao> searchByTitleOrStatus(String q, String status) {
        List<AcaoExtensao> result = new ArrayList<>();
        String qs = q == null ? "" : q.toLowerCase().trim();
        String st = status == null ? "" : status.toUpperCase().trim();

        for (AcaoExtensao a : acoes) {
            boolean matchesQuery = qs.isEmpty() ||
                    (a.getTitulo() != null && a.getTitulo().toLowerCase().contains(qs)) ||
                    (a.getDescricao() != null && a.getDescricao().toLowerCase().contains(qs));
            boolean matchesStatus = st.isEmpty() || a.getStatus().equalsIgnoreCase(st);
            if (matchesQuery && matchesStatus) {
                result.add(a);
            }
        }
        return result;
    }
}
