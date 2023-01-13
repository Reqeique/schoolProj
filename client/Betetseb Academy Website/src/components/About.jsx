import React from "react";

function About() {
  return (
    <div>
      <section className="about bg-colorPrimarySurfaceDark p-8 relative">
        <div className="relative">
          <img
            src="https://images.unsplash.com/photo-1510070112810-d4e9a46d9e91?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=869&q=80"
            alt=""
            className=""
          />
          <div className="overlay"></div>
        </div>
        <p className=" text-colorPrimarySurface absolute text-5xl w-4/5 top-24 left-24 font-crimson">
          Hello. Cruise School has been established in 1987 EC. We started with
          a bright vision and great ambition to make a visible and tangible
          change by delivering quality education to those who get enrolled with
          us and set a high standard to schools around our area in particular
          and to all over the{" "}
        </p>
      </section>
    </div>
  );
}

export default About;
