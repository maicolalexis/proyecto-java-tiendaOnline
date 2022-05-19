/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function (){
    $("tr #btnDelete").click(function (){
        var idp=$ (this).parent().find("#idp").val();
        const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: 'Are you sure?',
  text: "You won't be able to revert this!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: 'Yes, delete it!',
  cancelButtonText: 'No, cancel!',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
    eliminar(idp);
    swalWithBootstrapButtons.fire(
      'Deleted!',
      'Your file has been deleted.',
      'success'
    )
    

  } else if (
    /* Read more about handling dismissals below */
    result.dismiss === Swal.DismissReason.cancel
  ) {
    swalWithBootstrapButtons.fire(
      'Cancelled',
      'Your imaginary file is safe :)',
      'error'
    )
  }
})

        
    });
    function eliminar(idp){
        var url="ControladorCarrito?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp,
            success:function (data,textStatus, jqXHR){
                
                  location.href = 'ControladorCarrito?accion=Carrito';
            }
        });
    }
    $("tr #cantidad").click(function (){
        var idp = $(this).parent().find("#idpro").val();
        var cantidad = $(this).parent().find("#cantidad").val();
        var url ="ControladorCarrito?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp + "&cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR){
                  location.href = 'ControladorCarrito?accion=Carrito';
            }
        });
    });
});