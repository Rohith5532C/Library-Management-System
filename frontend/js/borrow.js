const STUDENT_API="http://localhost:8080/api/students";
const BOOK_API="http://localhost:8080/api/books";
const BORROW_API="http://localhost:8080/api/borrow";

loadStudents();
loadBooks();
loadRecords();

function loadStudents(){

    fetch(STUDENT_API)

        .then(r=>r.json())

        .then(data=>{

            student.innerHTML="";

            data.forEach(s=>{

                student.innerHTML+=`<option value="${s.id}">
${s.name}
</option>`;

            });

        });

}

function loadBooks(){

    fetch(BOOK_API)

        .then(r=>r.json())

        .then(data=>{

            book.innerHTML="";

            data.forEach(b=>{

                if(b.available){

                    book.innerHTML+=`<option value="${b.id}">
${b.title}
</option>`;

                }

            });

        });

}

function borrowBook(){

    const body={

        borrowDate:borrowDate.value,

        returnDate:returnDate.value

    };

    fetch(`${BORROW_API}/${student.value}/${book.value}`,{

        method:"POST",

        headers:{

            "Content-Type":"application/json"

        },

        body:JSON.stringify(body)

    })

        .then(()=>{

            loadBooks();

            loadRecords();

        });

}

function loadRecords(){

    fetch(BORROW_API)

        .then(r=>r.json())

        .then(data=>{

            records.innerHTML="";

            data.forEach(r=>{

                records.innerHTML+=`

<tr>

<td>${r.student.name}</td>

<td>${r.book.title}</td>

<td>${r.borrowDate}</td>

<td>${r.returnDate}</td>

<td>${r.returned?"Returned":"Borrowed"}</td>

<td>

<button onclick="returnBook(${r.id})">

Return

</button>

</td>

</tr>

`;

            });

        });

}

function returnBook(id){

    fetch(BORROW_API+"/return/"+id,{

        method:"PUT"

    })

        .then(()=>{

            loadBooks();

            loadRecords();

        });

}