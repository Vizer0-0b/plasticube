<!-- Large modal -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" id="goodsEdit" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="clearfix"></div>
      <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
          <div class="x_panel">
            <div class="x_title">
              <h2>Goods Edit <small>You can just modify goods's name here</small></h2>
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
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="id">id <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="id" name="id" required="required" readonly="readonly" class="form-control col-md-7 col-xs-12">
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">name <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="name" name="name" required="required" class="form-control col-md-7 col-xs-12">
                  </div>
                </div>
                <div class="form-group">
                  <label for="code" class="control-label col-md-3 col-sm-3 col-xs-12">code <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="code" name="code" required="required" readonly="readonly" class="form-control col-md-7 col-xs-12">
                  </div>
                </div>
                <div class="form-group">
                  <label for="remainNum" class="control-label col-md-3 col-sm-3 col-xs-12">remainNum <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="remainNum" name="remainNum" required="required" readonly="readonly" class="form-control col-md-7 col-xs-12">
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

  // goodsEdit Modal
  $(".goodsEdit").click(function(event){
    $("#goodsEdit").modal("show");
    e = event;
  });
  $("#goodsEdit").on("shown.bs.modal", function () {
    $("#goodsEdit").find("#id").val($(e.target).parent().parent().children("td#gid").html());
    $("#goodsEdit").find("#name").val($(e.target).parent().parent().children("td#gname").html());
    $("#goodsEdit").find("#code").val($(e.target).parent().parent().children("td#gcode").html());
    $("#goodsEdit").find("#remainNum").val($(e.target).parent().parent().children("td#gremainNum").html());
  });
  $("#goodsEdit").on("hidden.bs.modal", function () {
    $("#goodsEdit").find("#id").val("");
    $("#goodsEdit").find("#name").val("");
    $("#goodsEdit").find("#code").val("");
    $("#goodsEdit").find("#remainNum").val("");
  });

  $("#goodsEdit").find(":submit").click(function(){
    var patchData= {
        "id": $(e.target).parent().parent().children("td#gid").html(),
        "name": $("#goodsEdit").find("#name").val()};
    $.ajax({
      async : false,
      type : "PATCH",
      url : '/goodsrename',
      dataType : "json",
      data : patchData,
      error : function() {
        alert("oprating failed! Your value mabe invalid");
      },
      success : function(data) {
        alert(data.msg);
      }
    });
    $("#goodsEdit").modal("hide");
  });
}); 
</script> 