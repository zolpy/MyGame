/*package com.example.aluno.myapplication;


public class Camera extends Activity {
    implements SurfaceHolder.Callback {



        private Camera camera;

        private SurfaceView surfaceView;



        @Override

        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.main);



            camera = Camera.open();



            surfaceView = (SurfaceView) findViewById(R.id.preview);

            surfaceView.getHolder().addCallback(this);

        }



        @Override

        protected void onDestroy() {

            super.onDestroy();



            if (camera != null) {

                camera.release();

            }

        }



        @Override

        protected void onPause() {

            super.onPause();



            if (camera != null) {

                camera.stopPreview();

            }

        }



        @Override

        public void surfaceCreated(SurfaceHolder holder) {

            try {

                camera.setPreviewDisplay(holder);

                camera.startPreview();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        @Override

        public void surfaceChanged(SurfaceHolder holder, int format,

        int width, int height) {



            if (holder.getSurface() != null) {

                try {

                    camera.stopPreview();

                } catch (Exception e) {

                }

                try {

                    camera.setPreviewDisplay(holder);

                    camera.startPreview();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }



        @Override

        public void surfaceDestroyed(SurfaceHolder holder) {

        }

    }


}*/

