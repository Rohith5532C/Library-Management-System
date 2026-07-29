const API = "http://localhost:8080/api/students";

loadStudents();

function loadStudents() {

    fetch(API)

        .then(r=>r.json())

        .then(data=>{

            const table=document.getElementById("studentTable");

            table.innerHTML="";

            data.forEach(s=>{

                table.innerHTML+=`

<tr>

<td>${s.id}</td>

<td>${s.studentId}</td>

<td>${s.name}</td>

<td>${s.email}</td>

<td>${s.phone}</td>

<td>${s.department}</td>

<td>${s.year}</td>

<td>

<button onclick="deleteStudent(${s.id})">Delete</button>

</td>

</tr>

`;

            });

        });

}

function openForm(){

    popup.style.display="block";

}

function closeForm(){

    popup.style.display="none";

}

function saveStudent(){

    const student={

        studentId:studentId.value,

        name:name.value,

        email:email.value,

        phone:phone.value,

        department:department.value,

        year:year.value

    };

    fetch(API,{

        method:"POST",

        headers:{

            "Content-Type":"application/json"

        },

        body:JSON.stringify(student)

    })

        .then(()=>{

            closeForm();

            loadStudents();

        });

}

function deleteStudent(id){

    fetch(API+"/"+id,{

        method:"DELETE"

    })

        .then(()=>loadStudents());

}