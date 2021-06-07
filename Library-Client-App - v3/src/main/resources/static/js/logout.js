function logout() {
    e.preventDefault();
    let link = $(this).attr('href');
    Swal.fire({
        title: 'Are you sure?',
        toast: true,
        icon: 'warning',
        position: 'top-end',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes'
    }).then((result) => {
        if (result.isConfirmed) {
            window.location = link;
        }
    });
}