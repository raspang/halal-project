<div class=container>
<!-- Contact Form -->
      <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
      <div class="row">
        <div class="col-lg-8 mb-4">
          <h3>REQUEST FOR LABORATORY SERVICES</h3>
          <form name="sentMessage" id="contactForm" novalidate>

             <div class="control-group form-group">
              <div class="controls">
                <label>Email Address: <font color="red">*</font></label>
                <input type="email" class="form-control" id="email" required data-validation-required-message="Please enter your email address.">
              </div>              
            </div>

            <div class="control-group form-group">
              <div class="controls">
                <label>Name: <font color="red">*</font></label>
                <input type="text" class="form-control" id="name" required data-validation-required-message="Please enter your name.">
                <p class="help-block"></p>
              </div>
            </div>

            <div class="control-group form-group">
              <div class="controls">
                <label>Company: <font color="red">*</font></label>
                <input type="text" class="form-control" id="name" required data-validation-required-message="Please enter your company.">
                <p class="help-block"></p>
              </div>
            </div>

            <div class="control-group form-group">
              <div class="controls">
                <label>Complete Address: <font color="red">*</font></label>
                <input type="text" class="form-control" id="name" required data-validation-required-message="Please enter your complete address.">
                <p class="help-block"></p>
              </div>
            </div>

            <div class="control-group form-group">
              <div class="controls">
                <label>Telephone Number: <font color="red">*</font></label>
                <input type="text" class="form-control" id="name" required data-validation-required-message="Please enter your telephone number.">
                <p class="help-block"></p>
              </div>
            </div>

            <div class="control-group form-group">
              <div class="controls">
                <label>Fax Number: <font color="red">*</font></label>
                <input type="text" class="form-control" id="name" required data-validation-required-message="Please enter your fax number.">
                <p class="help-block"></p>
              </div>
            </div>

           <div class="control-group form-group">
              <div class="controls">
                <label>Phone Number:</label>
                <input type="text" class="form-control" id="name" required data-validation-required-message="Please enter your phone number.">
                <p class="help-block"></p>
              </div>        
           </div>

     


           <div class="control-group form-group">
             <div class="controls">
            <label>Types of Sample: <font color="red">*</font></label>
            
            <div class="form-check">
            <input class="form-check-input" type="radio" name="ToS" id="Food" value="option1">
            <label class="form-check-label" for="Food" >
             Food
            </label>
            </div>
             <div class="form-check">
            <input class="form-check-input" type="radio" name="ToS" id="Water" value="option2">
            <label class="form-check-label" for="Water">
             Water
            </label>
            </div>
             <div class="form-check">
            <input class="form-check-input" type="radio" name="ToS" id="Feed" value="option3">
            <label class="form-check-label" for="Feed">
             Feed
            </label>
            </div>
            <div class="form-check">
            <input class="form-check-input" type="radio" name="ToS" id="Other" value="option4"  checked>
            <label class="form-check-label" for="Other">
            Other:
              
                <p class="help-block"></p>
            </label>
            </div>
            <input type="text" class="form-control" id="other1" required data-validation-required-message="Please select or input type/s of sample." > 
            </div>
           </div>

            <div class="control-group form-group">
             <div class="controls">
            <label>Purpose of Analysis: <font color="red">*</font></label>
            
            <div class="form-check">
            <input class="form-check-input" type="radio" name="PoA" id="HalalTesting" value="option1">
            <label class="form-check-label" for="HalalTesting" >
             Halal Testing ( Verification/Validation)
            </label>
            </div>
             <div class="form-check">
            <input class="form-check-input" type="radio" name="PoA" id="RandD" value="option2">
            <label class="form-check-label" for="RandD">
             Research and Development 
            </label>
            </div>
             <div class="form-check">
            <input class="form-check-input" type="radio" name="PoA" id="RR" value="option3">
            <label class="form-check-label" for="RR">
             Regulatory Requierement
            </label>
            </div>
             <div class="form-check">
            <input class="form-check-input" type="radio" name="PoA" id="Reg" value="option3">
            <label class="form-check-label" for="Reg">
             Tariff/Registration 
            </label>
            </div>
            <div class="form-check">
            <input class="form-check-input" type="radio" name="PoA" id="Other" value="option4"  checked>
            <label class="form-check-label" for="Other">
            Other:
              
                <p class="help-block"></p>
            </label>
            </div>
            <input type="text" class="form-control" id="other2" required data-validation-required-message="Please select or input type/s of sample." > 
            
            </div>
           </div>

          <div class="control-group form-group">
             <div class="controls">
            <label>Select Appropriate Box: <font color="red">*</font></label>
            
            <div class="form-check">
            <input class="form-check-input" type="radio" name="SAB" id="Government" value="option1">
            <label class="form-check-label" for="Government" >
             Government
            </label>
            </div>
             <div class="form-check">
            <input class="form-check-input" type="radio" name="SAB" id="Private" value="option2">
            <label class="form-check-label" for="Private">
             Private
            </label>
            </div>
             <div class="form-check">
            <input class="form-check-input" type="radio" name="SAB" id="ManIn" value="option3">
            <label class="form-check-label" for="ManIn">
             Manufacturer/Industry
            </label>
            </div>
             <div class="form-check">
            <input class="form-check-input" type="radio" name="SAB" id="ManIn" value="option3">
            <label class="form-check-label" for="ManIn">
             Acadame
            </label>
            </div>
            <div class="form-check">
            <input class="form-check-input" type="radio" name="SAB" id="Other" value="option4"  checked>
            <label class="form-check-label" for="Other">
            Other:
              
                <p class="help-block"></p>
            </label>
            </div>
            <input type="text" class="form-control" id="other3" required data-validation-required-message="Please select or input type/s of sample." > 
            
            </div>
           </div>
           
            <div id="success"></div>
            <!-- For success/fail messages -->
            <button type="submit" class="btn btn-primary" id="sendMessageButton">Submit</button>
          </form>
        </div>
      </div>
 </div>