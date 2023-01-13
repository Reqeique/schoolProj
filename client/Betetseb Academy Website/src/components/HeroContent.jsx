import HeroImage from "../assets/hero-image-3.jpg";

const HeroContent = () => {
  const newLocal =
    "text-[6rem] font-bold leading-none mb-9 md:text-colorPrimarySurfaceDark hero-section-header";
  return (
    <div>
      <div className="text-colorPrimarySurface max-w-7xl mx-auto mt-6 p-4 flex items-center flex-col justify-center font-crimson text-center lg:hidden hero-main-box">
        <div className="bg-[] w-full">
          <h1 className="text-[7rem] font-light leading-none mb-9 md:text-colorPrimarySurfaceDark">
            Welcome To{" "}
            <span className="font-bold text-colorPrimaryDark">
              Beteseb Academy.
            </span>
          </h1>
          <h2 className="text-3xl text-[#a5a5a5]">
            We Teach the Future, We Touch
          </h2>
        </div>
        <img
          src={HeroImage}
          className="hidden w-4/5 md:block"
          alt="Home Page Image"
        />
      </div>

      {/* Large Screen */}
      <div className="lg:block hidden  relative hero-main-box mt-7">
        <div className="hero-container relative">
          <div className="content font-crimson">
            {/* <h1 className={newLocal} data-title="Welcome To Beteseb Academy."> */}
            <h1 className={newLocal} data-title="Welcome To Beteseb Academy.">
              Welcome To{" "}
              <span className="font-bold text-colorPrimaryDark">
                Beteseb Academy.
              </span>
              {/* <span class="wrap" aria-hidden="true">
                <span class="split" data-letters=" Welcome To Beteseb Academy.">
                  Welcome To Beteseb Academy.
                </span>
              </span> */}
            </h1>
            {/* <h2
              className="text-4xl font-light text-[#a5a5a5] hero-section-subheading"
              data-title="We Teach the Future, We Touch"
            > */}
            <h2
              className="text-4xl font-light text-[#a5a5a5] hero-section-subheading"
              data-title="We Teach the Future, We Touch"
            >
              We Teach the Future, We Touch
            </h2>
          </div>

          <img
            src={HeroImage}
            className="hidden w-6/5 md:block mt-17"
            alt="Home Page Image"
          />
        </div>
      </div>
    </div>
  );
};

export default HeroContent;
