function logout() {
    Swal.fire({
        title: 'Are you sure?',
        text: "You have to login again to access lirary again",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Logout'
    }).then((result) => {
         $.ajax({
            url: `/logout`,
            type: 'GET',
            success: () => {
                window.location.href = "/logout";
            }
        });
    })
}