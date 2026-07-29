loadDashboard();

function loadDashboard(){

    document.getElementById("mainContent").innerHTML=`

<h2>Dashboard</h2>

<div class="row">

<div class="col-md-3">

<div class="card p-3">

<h4 id="bookCount">0</h4>

Books

</div>

</div>

<div class="col-md-3">

<div class="card p-3">

<h4 id="studentCount">0</h4>

Students

</div>

</div>

<div class="col-md-3">

<div class="card p-3">

<h4 id="borrowCount">0</h4>

Borrowed

</div>

</div>

<div class="col-md-3">

<div class="card p-3">

<h4 id="librarianCount">0</h4>

Librarians

</div>

</div>

</div>

`;

    fetchDashboard();

}
const BASE="http://localhost:8080/api";

async function fetchDashboard(){

    let books=await fetch(BASE+"/books");
    books=await books.json();

    document.getElementById("bookCount").innerHTML=books.length;

}
async function loadBooks(){

    let response=await fetch(BASE+"/books");
    let books=await response.json();

    let html=`

<div class="d-flex justify-content-between">

<h2>Books</h2>

<button class="btn btn-primary" onclick="showBookForm()">

Add Book

</button>

</div>

<table class="table mt-4">

<thead>

<tr>

<th>ID</th>

<th>Title</th>

<th>Author</th>

<th>Status</th>

<th>Action</th>

</tr>

</thead>

<tbody>

`;

    books.forEach(book=>{

        html+=`

<tr>

<td>${book.id}</td>

<td>${book.title}</td>

<td>${book.author}</td>

<td>${book.available?"Available":"Borrowed"}</td>

<td>

<button class="btn btn-warning btn-sm">

Edit

</button>

<button class="btn btn-danger btn-sm">

Delete

</button>

</td>

</tr>

`;

    });

    html+=`

</tbody>

</table>

`;

    document.getElementById("mainContent").innerHTML=html;

}