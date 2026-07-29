const API="http://localhost:8080/api/librarians";

load();

function load(){

    fetch(API)

        .then(r=>r.json())

        .then(data=>{

            table.innerHTML="";
            librarianCards.innerHTML="";

            data.forEach(l=>{

                librarianCards.innerHTML += `

<div class="librarian-card">

    <h3>👤 ${l.name}</h3>

    <p><b>Email:</b> ${l.email}</p>

    <p><b>Phone:</b> ${l.phone}</p>

</div>

`;

                table.innerHTML+=`

<tr>

<td>${l.id}</td>

<td>${l.name}</td>

<td>${l.email}</td>

<td>${l.phone}</td>

<td>

<button onclick="remove(${l.id})">

Delete

</button>

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

function save(){

    fetch(API,{

        method:"POST",

        headers:{

            "Content-Type":"application/json"

        },

        body:JSON.stringify({

            name:name.value,

            email:email.value,

            phone:phone.value,

            password:password.value

        })

    })

        .then(()=>{

            closeForm();

            load();

        });

}

function remove(id){

    fetch(API+"/"+id,{

        method:"DELETE"

    })

        .then(()=>load());

}