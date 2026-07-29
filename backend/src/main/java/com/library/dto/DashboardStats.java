package com.library.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardStats {

    private Long totalBooks;
    private Long totalStudents;
    private Long totalLibrarians;
    private Long borrowedBooks;
    private Long availableBooks;
}