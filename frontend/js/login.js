const API="http://localhost:8080/api/login";

function login(){

    fetch(API,{

        method:"POST",

        headers:{

            "Content-Type":"application/json"

        },

        body:JSON.stringify({

            email:email.value,

            password:password.value

        })

    })

        .then(r=>r.json())

        .then(user=>{

            localStorage.setItem("user",
                JSON.stringify(user));

            if(user.role==="ADMIN"){

                window.location="dashboard.html";

            }
            else{

                window.location="dashboard.html";

            }

        })

        .catch(()=>{

            alert("Invalid Email or Password");

        });

}