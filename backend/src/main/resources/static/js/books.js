const API="/api/books";

loadBooks();

function loadBooks(){

    fetch(API)

        .then(res=>res.json())

        .then(data=>{

            const table=document.querySelector("tbody");

            table.innerHTML="";

            data.forEach(book=>{

                table.innerHTML+=`

<tr>

<td>${book.id}</td>

<td>${book.title}</td>

<td>${book.author}</td>

<td>${book.category}</td>

<td>${book.isbn}</td>

<td>

${book.available
                    ?
                    '<span style="color:green;font-weight:bold;">Available</span>'
                    :
                    '<span style="color:red;font-weight:bold;">Borrowed</span>'
                }

</td>
<td>

<button class="details-btn"
onclick="viewBook(${book.id})">

Details

</button>

</td>

<td>

<button class="edit-btn"
onclick="editBook(${book.id})">

Edit

</button>

</td>

<td>

<button class="delete-btn"
onclick="deleteBook(${book.id})">

Delete

</button>

</td>

</td>

</tr>

`;

            });

        });

}

function openForm(){

    document.getElementById("popup").style.display="block";

}

function closeForm(){

    document.getElementById("popup").style.display="none";

}

function saveBook(){

    const book={

        title:title.value,

        author:author.value,

        publisher:publisher.value,

        category:category.value,

        isbn:isbn.value,

        quantity:Number(quantity.value),

        availableCopies:Number(quantity.value),

        available:true

    };

    let url=API;
    let method="POST";

    if(editingId!=null){

        url=API+"/"+editingId;
        method="PUT";

    }

    fetch(url,{

        method:method,


        headers:{

            "Content-Type":"application/json"

        },

        body:JSON.stringify(book)

    })

        .then(()=>{

            closeForm();

            loadBooks();

        });

}

function deleteBook(id){

    if(confirm("Delete this book?")){

        fetch(API+"/"+id,{

            method:"DELETE"

        })

            .then(()=>loadBooks());

    }

}
let editingId = null;

function editBook(id){

    editingId=id;

    fetch(API+"/"+id)

        .then(r=>r.json())

        .then(book=>{

            title.value=book.title;
            author.value=book.author;
            publisher.value=book.publisher;
            category.value=book.category;
            isbn.value=book.isbn;
            quantity.value=book.quantity;

            openForm();

        });

}
function viewBook(id){

    fetch(API+"/"+id)

        .then(r=>r.json())

        .then(book=>{

            alert(

                "Title : "+book.title+

                "\nAuthor : "+book.author+

                "\nPublisher : "+book.publisher+

                "\nCategory : "+book.category+

                "\nISBN : "+book.isbn+

                "\nQuantity : "+book.quantity+

                "\nAvailable : "+book.availableCopies

            );

        });

}
document.getElementById("search").addEventListener("keyup",function(){

    let value=this.value.toLowerCase();

    let rows=document.querySelectorAll("tbody tr");

    rows.forEach(row=>{

        row.style.display=row.innerText.toLowerCase().includes(value)

            ? ""

            : "none";

    });

});