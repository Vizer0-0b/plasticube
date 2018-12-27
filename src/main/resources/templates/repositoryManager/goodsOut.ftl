<!-- Large modal -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" id="goodsOut" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="clearfix"></div>
      <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
          <div class="x_panel">
            <div class="x_title">
              <h2>Goods Out <small>Goods out from repository</small></h2>
              <ul class="nav navbar-right panel_toolbox">
                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                </li>
              </ul>
              <div class="clearfix"></div>
            </div>
            <div class="x_content">
              <br />
              <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="" method="">
                <div class="form-group">
                  <label for="quantity" class="control-label col-md-3 col-sm-3 col-xs-12">quantity <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="quantity" name="quantity" required="required" class="form-control col-md-7 col-xs-12">
                  </div>
                </div>
                <div class="ln_solid"></div>
                <div class="form-group">
                  <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-8">
                    <button type="submit" class="btn btn-success">Submit</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript"> 
$(document).ready(function(){
  //temp event
  var e;

  // goodsOut Modal
  $(".goodsOut").click(function(event){
    $("#goodsOut").modal("show");
    e = event;
  });
  $("#goodsOut").on("shown.bs.modal", function () {
  });
  $("#goodsOut").on("hidden.bs.modal", function () {
    $("#goodsOut").find("#quantity").val("");
  });

  $("#goodsOut").find(":submit").click(function(){
    var patchData= {
        "id": $(e.target).parent().parent().children("td#gid").html(),
        "quantity": $("#goodsOut").find("#quantity").val()};
    $.ajax({
      async : false,
      type : "PATCH",
      url : '/goodsout',
      dataType : "json",
      data : patchData,
      error : function() {
        alert("oprating failed! Your value mabe invalid");
      },
      success : function(data) {
        alert(data.msg);
      }
    });
    $("#goodsOut").modal("hide");
  });
}); 
</script> 