const DASHBOARD_API="/api/dashboard/stats";

loadDashboard();

function loadDashboard(){

    fetch(DASHBOARD_API)

        .then(res=>res.json())

        .then(data=>{

            booksCount.innerHTML=data.totalBooks;

            studentsCount.innerHTML=data.totalStudents;

            librariansCount.innerHTML=data.totalLibrarians;

            borrowedCount.innerHTML=data.borrowedBooks;

            availableCount.innerHTML=data.availableBooks;

        });

    fetch("/api/borrow")

        .then(r=>r.json())

        .then(data=>{

            recentBorrow.innerHTML="";

            data.reverse().slice(0,5).forEach(record=>{

                recentBorrow.innerHTML+=`

<tr>

<td>${record.student.name}</td>

<td>${record.book.title}</td>

<td>${record.borrowDate}</td>

<td>${record.returnDate}</td>

<td>

${record.returned

                    ?'<span style="color:green;">Returned</span>'

                    :'<span style="color:red;">Borrowed</span>'}

</td>

</tr>

`;

            });

        });

}